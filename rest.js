const express = require("express")
const mysql = require("mysql")
const bodyParser = require("body-parser")
const app = express()

const connection = mysql.createConnection({
    host     : 'localhost',
    port: '3308',
    user: 'root',
    password: '',
    database:'db-esiflix'
})

connection.connect(function(err) {
    if (err) {
        console.error('error connecting: ' + err.stack);
        return;
    }

    console.log('connected as id ' + connection.threadId);
})

app.use(bodyParser.json())

app.get('/getmovies', function(req, res){
    const query = "SELECT * FROM movie"
    connection.query(query , function(error, results){
        if(error) throw(error)
        res.send(JSON.stringify(results))
    })
})



app.get('/getmovie/:title',function(req,res) {
    const query = "select * from users where title=?";
    connection.query(query, [req.params.title], function (error, results) {
        if (error) throw(error)
        res.send(JSON.stringify(results[0]))
    })
})

app.post('/add/movie', function(req, res){
    const query = "INSERT INTO Movie(title,year,language) VALUES(?,?,?)"
    connection.query(query,[req.body.title, req.body.year, req.body.language], function(error){
        if(error) {console.log(error.toString())}
        res.status(200).send('Film correctement ajouté.')
    })
})

app.get('/getactors', function(req,res){
    const query = "SELECT * FROM Actor"
    connection.query(query,function (error, results) {
        if(error) throw error
        res.send(JSON.stringify(results))
    })
})

app.post('/add/actor', function(req, res){
    const query = "INSERT INTO Actor(firstName,lastName,gender) VALUES(?,?,?)"
    connection.query(query,[req.body.firstName, req.body.lastName, req.body.gender], function(error){
        if(error) {console.log(error.toString())}
        res.status(200).send('Acteur correctement ajouté.')
    })
})


const server = app.listen(8082,function(){
    const host = server.address().address
    const port = server.address().port
})

console.log('Le serveur a démarré correctement.')