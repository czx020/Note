setwd("d://")
data<-read.csv("model.csv",header = TRUE,stringsAsFactors = FALSE)
data$�Ƿ���©��<-as.factor(data$�Ƿ���©��)
ind<-sample(1:2,size=nrow(data), replace = TRUE,prob=c(0.7,0.3))
traindata<-data[ind==1,]
testdata<-data[ind==2,]

library(tree)
tree.model<-tree(�Ƿ���©��~.,data=traindata)
plot(tree.model,type="uniform")
text(tree.model)
