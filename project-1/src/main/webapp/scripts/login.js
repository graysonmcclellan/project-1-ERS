/**
 * 
 */

function sendLogin()
{
    console.log("sendLogin() started.")
    let uName = document.getElementById("uName").value;
    let pWord = document.getElementById("pWord").value;
    console.log("Username " + uName)
    console.log("Password " + pWord)
    let loginTemplate = {
        username: uName,
        password: pWord
    }
    //This begins AJAX workflow
    //creates ajax object 
    let xhr = new XMLHttpRequest()
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200)
        {
            console.log("Success")

            console.log("grayson and isa2")
            sessionStorage.setItem('currentUser', this.responseText)


            var cur = sessionStorage.getItem('currentUser')

            var json = JSON.parse(cur);

            console.log(json)
            console.log(json["roleId"])
            var roleId = json.roleId

            console.log(roleId)

            window.location = "http://localhost:8080/project-1/emporad"
            xhr.open("POST","http://localhost:8080/project-1/emporad")

        
        // var json = JSON.parse(this.responseText);
        
        // alert(json["username"]);
        // alert(json.username);

            console.log(sessionStorage.getItem('currentUser'))
        }
        if(this.readyState ===4 && this.status ===204)
        {
            console.log("Failed")
            alert("Failed to log in! Username or password is incorrect")
            //let childDiv= document.getElementById("warningText")
            //childDiv.textContent ="Failed to log in! Username or Password is incorrect"
        }
        console.log("Processing")
        
    }
    xhr.open("POST","http://localhost:8080/project-1/login")
    xhr.send(JSON.stringify(loginTemplate))
}

function createUser(){

 //This begins AJAX workflow
    let xhr = new XMLHttpRequest()
    xhr.open("POST","http://localhost:8080/project-1/newUser")
    }





