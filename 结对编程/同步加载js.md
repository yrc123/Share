只能通过xhr加载js文本，然后通过eval执行

```js
var xhrObj = new XMLHttpRequest();
xhrObj.open('GET', '/filename.js', false);
xhrObj.send(null);
eval(xhrObj.responseText);
```

