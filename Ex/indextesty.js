var crypto = require ('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

var con = mysql.createConnection({
		host:'127.0.0.1',
		user: 'root',
		password: '1234',
		database:'test'
});

var genRandomString = function(length){
	return crypto.randomBytes(Math.ceil(length/2))
	.toString('hex')
	.slice(0,length);
};

var sha512 = function(password,salt){
	var hash = crypto.createHmac('sha512', salt);
	hash.update(password);
	var value = hash.digest('hex');
	return {
		salt:salt,
		passwordHash:value
	}
};

function saltHashPassword(userPassword){
	var salt = genRandomString(16);
	var passwordData = sha512(userPassword,salt);
	return passwordData;
}

var app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.get("/",(req,res,next)=>{
	console.log('Password: 123456');
	var encrypt = saltHashPassword("123456");
	console.log('Encrpyt: '+encrypt.passwordHash);
	console.log('Salt: '+encrypt.salt);
});

app.listen(3000, ()=>{
	console.log('EDMTDev Restful running on port 3000');
})