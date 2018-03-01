/**
 * 
 */
import cookie from 'react-cookie';

function get(url, cb) {
	fetch(url, {
	    method: 'GET',
	    credentials: 'same-origin',
	    redirect: 'follow'
	}).then(function(res) {
	    if (res.ok) {
	    	res.json().then(function(obj) {
	    		if (obj.result) {
	    			cb({result: obj.result, data: obj.data});
	    		} else {
	    			if (obj.code == 2017) {
	    				cookie.remove('signinStatus');
		    			cookie.remove('signinUsername');
		    			cookie.remove('signinUserId');
		    			cookie.remove('signinType');
	    				window.location.href = "/#/user/signin";
	    			} else {
	    				cb({result: obj.result, data: obj.message});
	    			}
	    		}
	    	});
	    }
	}).catch(function(error) {
		cb({result: false, data: "request failed"});
	})
}

export default get;