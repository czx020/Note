#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2018-11-06 08:30:01
# Project: MaFengWo

from pyspider.libs.base_handler import *
import json
from pyspider.libs.utils import md5string
import re

class Handler(BaseHandler):
    crawl_config = {
    }

    @every(minutes=24 * 60)
    def on_start(self):
        self.crawl('http://www.mafengwo.cn/jd/10088/gonglve.html', callback=self.index_page,fetch_type='js')
        
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
        result = response.text.replace('\\',' ')
        pattern = re.compile('<a href="(.*?)" target=')
        urls = re.findall(pattern,result)
        for url in urls:
            self.crawl('www.mafengwo.cn'+url, callback=self.detail_page)

    @config(priority=2)
    def detail_page(self, response):
        return {
            "title": response.doc('h1').text(),
        }
