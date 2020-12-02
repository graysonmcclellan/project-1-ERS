/**
 * 
 */
sendLogin()


function sendLogin()
{
   

        console.log("grayson %%% isa1")
           let user = sessionStorage.getItem('currentUser')
           
        
        var json = JSON.parse(user);
        
        // alert(json["username"]);
        // alert(json.username);

           let trElem= document.getElementById("welcomeAdmin")
            trElem.textContent =`Welcome ${json.firstName} to the Admin Portal`
}
