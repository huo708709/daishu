var daishu = {
    version: '0.0.1'
};
(function(ds) {
    ds.store = {};
    ds.cookie = {};
    ds.sessStore = {};
    if (!window.localStorage || !window.sessionStorage ) {
        return;
    }
    //html5应用程序缓存
    if (window.applicationCache) {
        ds.store.cache = window.applicationCache;
    }
    /**
     * 添加localStorage缓存
     * @param key
     * @param val
     * @param noversion
     * @param cacheTime
     */
    ds.store.set = function(key, val, noversion, cacheTime) {
        if (!noversion) key = ds.version + key;
        if (cacheTime) {
            var cacheTime_old = parseInt(localStorage.getItem(key + '_ct'));
            if (!isNaN(cacheTime_old) && cacheTime_old > 0 && cacheTime_old < Date.parse(new Date())/1000) {
                localStorage.setItem(key + '_ct', Date.parse(new Date())/1000 + parseInt(cacheTime));
            }
        }
        if(typeof(val) == 'object') {
            localStorage.setItem(key, JSON.stringify(val));
        } else {
            localStorage.setItem(key, val);
        }
    };
    /**
     * 清除localStorage缓存
     */
    ds.store.clear = function() {
        localStorage.clear();
    };
    /**
     * 获得localStorage缓存内容
     * @param key
     * @param noversion
     * @returns
     */
    ds.store.get = function(key, noversion) {
        if (!noversion) key = ds.version + key;
        var cacheTime = parseInt(localStorage.getItem(key + '_ct'));
        if (!isNaN(cacheTime) && cacheTime > 0 && cacheTime < Date.parse(new Date())/1000) {
            localStorage.removeItem(key);
            localStorage.removeItem(key + '_ct');
            return false;
        }
        var val = localStorage.getItem(key);
        if(!val) return false;
        if(val.indexOf('{') == 0 || val.indexOf('[') == 0) val = JSON.parse(val);
        return(val);
    }
    /**
     * 清除sessionStorage缓存
     */
    ds.sessStore.clear = function() {
        sessionStorage.clear();
    }

    /**
     * 添加sessionStorage缓存
     * @param key
     * @param val
     */
    ds.sessStore.set = function(key, val) {
        if(typeof(val) == 'object') {
            sessionStorage.setItem(key, JSON.stringify(val));
        } else {
            sessionStorage.setItem(key, val);
        }
    }

    /**
     * 获得sessionStorage缓存内容
     * @param key
     * @returns
     */
    ds.sessStore.get = function(key) {
        var val = sessionStorage.getItem(key);
        if(!val) return false;
        if(val.indexOf('{') == 0 || val.indexOf('[') == 0) val = JSON.parse(val);
        return(val);
    }

    ds.cookie.get = function (name) {
        var arr,reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if(arr = document.cookie.match(reg))
            return unescape(arr[2]);
        else
            return null;
    }

    ds.cookie.del = function delCookie(name) {
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = rz.cookie.get(name);
        if(cval != null)
            document.cookie= name + "=" + cval + ";expires=" + exp.toGMTString();
    }
})(daishu);
(function(ds) {
    ds.io = {};

    ds.io.generateUrl = function(module, datas, jsonp) {
        // ts
        var ts = new Date().getTime();
        datas['timestamp'] = ts;

        // jsonp callback
        datas['jsonp'] = jsonp;

        // make sign
        var signstr = rz.io.makeSign(module, ts);
        datas['sign'] = signstr;

        // generate param url
        var paramurl = '';
        for(var key in datas)
            paramurl += key + '=' + datas[key] + '&';

        if(module == 'publishcomment' || module == 'uploadcommentimage') {
            return urlroot + module + '?' + paramurl;
        } else {
            return urlroot + module + '?' + paramurl;
        }
    };
    /**
     * GET ajax
     */
    ds.io.httpget = function(url, params, jsonp, success, error) {
        var req = $.ajax({
            type: 'GET',
            url: url,
            dataType: jsonp != '' ? 'jsonp' : 'json',
            async: true
        });
        if (success) req.success(success);
        if (error) req.success(error);
    }
    /**
     * POST ajax
     */
    ds.io.httppost = function(url, params, jsonp, success, error) {
        $.ajax({
            type: 'POST',
            url: url,
            dataType : 'json',
            data: params,
            success: function(data) {
            	if(success) {
            		if (0 == data.code || '0' == data.code) {
            			success.apply(this, [data.data]);
            		} else {
            			if (data.action == 'alert') {
            				alert(data.message);
            			}
            			error.apply(this, [data.data]);
            		}
                }
            },
            error: function() {
            	if(error) {
                	error.apply(this, arguments);
                }
            }
        });
    }
})(daishu);