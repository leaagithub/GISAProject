var crypto = require ('crypto');
var uuid = require('uuid');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');
var GProjectID;
var connection = mysql.createConnection({
  host     : 'mygisainst.c7mj9olumnzo.us-west-1.rds.amazonaws.com',
  user     : 'GISAlogin',
  password : 'GISA2018pass',
  database : 'GISA'
});

var app = express();

app.listen(3000);
console.log('Example app listening at port:3000');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

connection.connect(function(err) {
	if (err) throw err;
	console.log("Connected!");
});
app.post('/submitIncidentReport/',(req,res)=>{
    var post_data = req.body;
	//Incident Report Table VAR
	console.log(post_data);
    var DateOfIncident = post_data.DateOfIncident;
    var DateOfReport = post_data.DateOfReport;
    var District = post_data.District;
    var County = post_data.County;
    var Route = post_data.Route;
    var Latitude = post_data.Latitude;
    var Longitude = post_data.Longitude;
    var Observation = post_data.Observation;
    var EmployeeId = post_data.EmployeeID;
	var Distribution = post_data.Distribution;
	var HighwayStatus = post_data.HighwayStatus;
	var ClosedLanes = post_data.ClosedLanes;
	var WaterContent = post_data.WaterContent;
	var AdjacentUtilities = post_data.AdjacentUtilities;
	var AdjacentProperties = post_data.AdjacentProperties;
	var Sketch = post_data.Sketch;
	var Photos = post_data.Photos;
	var sql = 'INSERT INTO IncidentReport (DateOfIncident,DateOfReport,District,County,Route,Latitude,Longitude,Observation,EmployeeId,Distribution,HighwayStatus,ClosedLanes,WaterContent,AdjacentUtilities,AdjacentProperties,Photos) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);'
	connection.query(sql,[DateOfIncident,DateOfReport,District,County,Route,Latitude,Longitude,Observation,EmployeeId,Distribution,HighwayStatus,ClosedLanes,WaterContent,AdjacentUtilities,AdjacentProperties,Photos],function (err, result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('Incident Report Registered');
		console.log('Incident Report Registered Successful!!');
	});
	sql = 'SELECT ProjectID FROM IncidentReport ORDER BY ProjectID DESC LIMIT 1';
	connection.query(sql,function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MYSQL ERROR]',err);
		});
		res.end('Successful Incident Report');
		console.log(result[0].ProjectID);
		GProjectID = result[0].ProjectID;
	});
})
app.post('/submitMaterial/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var flag = 0;
	var ProjectID = GProjectID;
	var TypeOfMaterial = post_data.TypeOfMaterial;
	var Bedding = post_data.Bedding;
	var Joints = post_data.Joints;
	var Fractures = post_data.Fractures;
	var Clay = post_data.Clay;
	var Silt = post_data.Silt;
	var Sand = post_data.Sand;
	var Gravel = post_data.Gravel;
	var sql = 'INSERT INTO Material (ProjectID,TypeOfMaterial,Bedding,Joints,Fractures,Clay,Silt,Sand,Gravel) VALUES (?,?,?,?,?,?,?,?,?);'
	connection.query(sql,[ProjectID,TypeOfMaterial,Bedding,Joints,Fractures,Clay,Silt,Sand,Gravel],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('Material Table Registered');
		console.log(ProjectID + 'Material Table');
		console.log('Material Table Registered Successful!!');
	});
	flag = 1;
})
app.post('/submitFollowUpActions/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var FollowUpActions = post_data.FollowUpActions;
	var OpenLines = post_data.OpenLines;
	var sql = 'INSERT INTO FollowUpActions (ProjectID,FollowUpActions,OpenLines) VALUES (?,?,?);'
	connection.query(sql,[ProjectID,FollowUpActions,OpenLines],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('FollowUpActions Table Registered');
		console.log(ProjectID);
		console.log('FollowUpActions Table Registered Successful!!');
	});
})
app.post('/submitImmediateActions/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var ImmediateActions = post_data.ImmediateActions;
	var OpenLines = post_data.OpenLines;
	var sql = 'INSERT INTO ImmediateActions (ProjectID,ImmediateActions,OpenLines) VALUES (?,?,?);'
	connection.query(sql,[ProjectID,ImmediateActions,OpenLines],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('ImmediateActions Table Registered');
		console.log(ProjectID);
		console.log('ImmediateActions Table Registered Successful!!');
	});
})
app.post('/submitIncidentType/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var IncidentType = post_data.IncidentType;
	var sql = 'INSERT INTO IncidentType (ProjectID,IncidentType) VALUES (?,?);'
	connection.query(sql,[ProjectID,IncidentType],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('IncidentType Table Registered');
		console.log(ProjectID);
		console.log('IncidentType Table Registered Successful!!');
	});
})
app.post('/submitMeasurements/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var SlopeHeight_ft = post_data.SlopeHeight_ft;
	var OriginalSlope_deg = post_data.OriginalSlope_deg;
	var LandslideWidth_ft = post_data.LandslideWidth_ft;
	var LandslideLength_ft = post_data.LandslideLength_ft;
	var MainScarpHeight_ft = post_data.MainScarpHeight_ft;
	var LandslideSlope_deg = post_data.LandslideSlope_deg;
	var LengthOfRoadwayEncroached_ft = post_data.LengthOfRoadwayEncroached_ft;
	var WidthOfRoadwayEncroached_ft = post_data.WidthOfRoadwayEncroached_ft;
	var sql = 'INSERT INTO Measurements (ProjectID,SlopeHeight_ft,OriginalSlope_deg,LandslideWidth_ft,LandslideLength_ft,MainScarpHeight_ft,LandslideSlope_deg,LengthOfRoadwayEncroached_ft,WidthOfRoadwayEncroached_ft) VALUES (?,?,?,?,?,?,?,?,?);'
	connection.query(sql,[ProjectID,SlopeHeight_ft,OriginalSlope_deg,LandslideWidth_ft,LandslideLength_ft,MainScarpHeight_ft,LandslideSlope_deg,LengthOfRoadwayEncroached_ft,WidthOfRoadwayEncroached_ft],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('Measurements Table Registered');
		console.log(ProjectID);
		console.log('Measurements Table Registered Successful!!');
	});
})
app.post('/submitPavement_Ground_Status/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var PavementGroundCracks = post_data.PavementGroundCracks;
	var CrackLength_feet = post_data.CrackLength_feet;
	var CrackHorisontalDisposiion_inch = post_data.CrackHorisontalDisposiion_inch;
	var CrackVerticalDisposiion_inch = post_data.CrackVerticalDisposiion_inch;
	var DepthOfCrack_inch = post_data.DepthOfCrack_inch;
	var Settlement_inch = post_data.Settlement_inch;
	var Bulge_inch = post_data.Bulge_inch;
	var IndentedByRocks = post_data.IndentedByRocks;
	var sql = 'INSERT INTO Pavement_Ground_Status (ProjectID,PavementGroundCracks,CrackLength_feet,CrackHorisontalDisposiion_inch,CrackVerticalDisposiion_inch,DepthOfCrack_inch,Settlement_inch,Bulge_inch,IndentedByRocks) VALUES (?,?,?,?,?,?,?,?,?);'
	connection.query(sql,[ProjectID,PavementGroundCracks,CrackLength_feet,CrackHorisontalDisposiion_inch,CrackVerticalDisposiion_inch,DepthOfCrack_inch,Settlement_inch,Bulge_inch,IndentedByRocks],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('Pavement_Ground_Status Table Registered');
		console.log(ProjectID);
		console.log('Pavement_Ground_Status Table Registered Successful!!');
	});
})
app.post('/submitVegetationOnSlope/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var Trees = post_data.Trees;
	var Bushes_Shrubs = post_data.Bushes_Shrubs;
	var GroundCover = post_data.GroundCover;
	var sql = 'INSERT INTO VegetationOnSlope (ProjectID,Trees,Bushes_Shrubs,GroundCover) VALUES (?,?,?,?);'
	connection.query(sql,[ProjectID,Trees,Bushes_Shrubs,GroundCover],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('VegetationOnSlope Table Registered');
		console.log(ProjectID);
		console.log('VegetationOnSlope Table Registered Successful!!');
	});
})
app.post('/submitWater_Drainage/',(req,res,next)=>{
	var post_data = req.body;
	console.log(post_data);
	var ProjectID = GProjectID;
	var Water_Drainage = post_data.Water_Drainage;
	var sql = 'INSERT INTO Water_Drainage (ProjectID,Water_Drainage) VALUES (?,?);'
	connection.query(sql,[ProjectID,Water_Drainage],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL Error]',err);
			res.json('SQL error: ',err);
		});
		res.end('Water_Drainage Table Registered');
		console.log(ProjectID);
		console.log('Water_Drainage Table Registered Successful!!');
	});
})
app.post('/register/',(req,res)=>{
	var post_data = req.body; //GET POST PARAMETERS
	console.log(post_data);
	var eid = post_data.eid;
	var fname = post_data.fname;
	var lname = post_data.lname;
	var phoneno = post_data.phoneno;
	var password = post_data.password;
	var email = post_data.email;
	
	
	connection.query('SELECT * FROM Employee WHERE CaltransID =?',[eid],
		function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MySQL ERROR]',err);
		});
		if(result && result.length){
			res.json('User already exists!!!');
            console.log('User already exists!!!');
		}
		else
		{
			//var sql = "INSERT Into Employee(CaltransID, FName, LName, PhoneNo, Password, Email) VALUES( ? , ? , ? , ? , ?, ?);";
			connection.query("INSERT Into Employee(CaltransID, FName, LName, PhoneNo, Password, Email) VALUES( ? , ? , ? , ? , ?, ?);",[eid,fname,lname,phoneno,password,email],
			function (err, result,fields){
			connection.on('error',function(err){
				console.log('[MySQL Error]',err);
				res.json('Register error: ',err);
			});
			res.end('Registered');
            console.log('Register Successful!!');
		})
		}
	});
})

app.post('/login',(req,res,next)=>{
	var post_data = req.body;
	var user_password = post_data.password;
	var user_eid = post_data.eid;
	connection.query('SELECT * FROM Employee WHERE CaltransID =?',[user_eid],function(err,result,fields){
		connection.on('error',function(err){
			console.log('[MYSQL ERROR]',err);
		});

		if(result && result.length){
			var password = result[0].Password; 
			if(user_password == password){
				//res.end(JSON.stringify(result[0])); //RETURNS USER INFO
                res.end('Successful');
                console.log('Login Successful');
			}
			else{
				res.end(JSON.stringify('Wrong Password'));
                console.log('Wrong Passowrd');
            }
		}
		else{
			res.json('User Does Not Exists');
            console.log('User not exists');
		}
	});
})

app.get('/test',function(req,res){
	res.send('Hello This is a Test');
	console.log(GProjectID);
});