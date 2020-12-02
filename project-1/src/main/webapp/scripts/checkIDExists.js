/**
 * 
 */


function approve()
{
    
    
    let xhr = new XMLHttpRequest()
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200)
        {
            console.log("Success")

            console.log("has been approved")
           // sessionStorage.setItem('currentUser', this.responseText)


            alert("Reimbursement has been approved! Return to Main Menu or Approve Another Reimbursement.")


            window.location = "http://localhost:8080/project-1/admin"
            //xhr.open("POST","http://localhost:8080/project-1/emporad")

        

        }
        if(this.readyState ===4 && this.status ===204)
        {
            console.log("Failed")
            alert("Reimbursement ID does not exist. Please try again.")
            //let childDiv= document.getElementById("warningText")
            //childDiv.textContent ="Failed to log in! Username or Password is incorrect"
        }
        console.log("Processing")
      
    }
        console.log("Redirecting")

    window.location = "http://localhost:8080/project-1/approvereimbursement"
    xhr.open("POST","http://localhost:8080/project-1/approvereimbursement")
   
}
