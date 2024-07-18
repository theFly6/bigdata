// 导入Express模块
const express = require('express');
// 创建一个Express应用
const app = express();
// fs文件读取模块
const fs = require('fs');
const path = require('path');

app.use((req, res, next) => {
  res.setHeader("Access-Control-Allow-Origin", "*")
  console.log("有人访问了服务器：", req.url, req.method, req.query)
  next()
})

app.post('/show/cityJob', (req, res) => {
  const file = path.join(__dirname, '/json/cityjob.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

app.post('/show/companyproperty', (req, res) => {
  const file = path.join(__dirname, '/json/companyproperty.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

app.post('/show/companysize', (req, res) => {
  const file = path.join(__dirname, '/json/companysize.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

app.post('/show/jobpost', (req, res) => {
  const file = path.join(__dirname, '/json/jobpost.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

app.post('/show/jobsalary', (req, res) => {
  const file = path.join(__dirname, '/json/jobsalary.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

app.post('/show/wordcloud', (req, res) => {
  const file = path.join(__dirname, '/json/wordcloud.json')
  fs.readFile(file, 'utf-8', function (err, data) {
    if (err) {
      res.send('文件读取失败');
    } else {
      res.send(data);
    }
  })
})

// 设置服务器监听8081端口
app.listen(8081, () => {
  console.log('Server is running on http://localhost:8081');
});
