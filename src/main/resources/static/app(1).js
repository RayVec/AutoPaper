import React from "react";
import ReactDOM from "react-dom";
import {
//	BrowserRouter as Router,
	HashRouter as Router,
	Route,
	Link, 
	Redirect
} from 'react-router-dom'

function test(e) {
	e.preventDefault();
	alert(123);
}


const BasicExample = (match, location) => (
  <Router>
    	<div className="row">
    		<div className ="col-md-12">
    			<div className="main-wrapper">
    				<Route exact path="/" component={Home}/>
    			</div>

		    </div>
	    </div>
  </Router>
)


const Home = (match, location) => (
	<form action="/user/file/upload" method="post" encType="multipart/form-data">
		<input type="file" name="file" />
		<input type="submit" value="上传文件1" />
	</form>
)

ReactDOM.render(<BasicExample />, document.getElementById('app'));