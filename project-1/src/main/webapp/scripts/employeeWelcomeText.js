sendLogin()


function sendLogin()
{
   

        console.log("grayson %%% isa1")
           let user = sessionStorage.getItem('currentUser')
           
        
        var json = JSON.parse(user);
        
        // alert(json["username"]);
        // alert(json.username);

           let trElem= document.getElementById("personalWelcome")
            trElem.textContent =`Welcome ${json.firstName} to the Employee Portal`
}
