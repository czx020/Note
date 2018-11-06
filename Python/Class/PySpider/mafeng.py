#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2018-11-06 11:52:31
# Project: PySpider_MaFengWo

from pyspider.libs.base_handler import *
import json
from pyspider.libs.utils import md5string
import re
from fake_useragent import UserAgent

class Handler(BaseHandler):
    
    crawl_config = {

    }
    
    @every(minutes=24 * 60)
    def on_start(self):
        headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36 OPR/54.0.2952.64' }
        self.crawl('http://www.mafengwo.cn/jd/10088/gonglve.html', callback=self.get_index,fetch_type='js',headers = headers)
        
    def get_taskid(self, task):
        return md5string(task['url']+json.dumps(task['fetch'].get('data', '')))
        
    def get_index(self,response):
        url = 'http://www.mafengwo.cn/ajax/router.php'
        total = int(response.doc('.pi.pg-last').attr('data-page'))
        for i in range(1,total+1):
            data = {
                    'sAct':'KMdd_StructWebAjax|GetPoisByTag',
                    'iMddid':'10088',
                    ' iTagId':0,
                    'iPage':i
             }
            self.crawl(url,method='POST',data=data,callback=self.index_page)
                                       
    @config(age=10 * 24 * 60 * 60)
    def index_page(self, response):
        print(response.text)
        result = response.text.replace('\\','')
        print(result)
        pattern = re.compile('<a href="(.*?)" target=')
        urls = re.findall(pattern,result)
        for url in urls:
            self.crawl('www.mafengwo.cn'+url, callback=self.detail_page,fetch_type='js')

    @config(priority=2)
    def detail_page(self, response):
        return {
            "name": response.doc('h1').text(),
            "price":response.doc('h1').text(),
            "phone":response.doc('h1').text(),
            "website":response.doc('h1').text(),
            
        }
