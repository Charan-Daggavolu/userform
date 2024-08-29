"# Adding Nodes & viewing all nodes & Import CSV file to database"

• Schema design based on Figma attributes. 
• Validations to ensure data integrity and prevent invalid inputs. 
• RESTful APIs to add and fetch nodes. 
• Validated code through SonarQube.
• Containerized MySQL setup using Docker. 
• With help of jenkins pipeline Script created image and container for MySQL and Application and deployed. 
• Scalable and secure deployment using AWS EC2.


Testing: Use postman 
34.232.14.85 this elastic ip 
POST method : http://34.232.14.85:8000/api/users/addnode -- Add nodes 
GET method : http://34.232.14.85:8000/api/users/allnodes -- Get all nodes  
POST method : http://34.232.14.85:8000/api/users/import ---- importing CSV --- CSV file need to be 
uploaded for this api 

Note: These are free tier EC2 instance urls. 

If above URLs is not working, then please clone this project and run locally:  
POST method : http://localhost:8000/api/users/addnode -- Add nodes 
GET method : http://localhost:8000/api/users/allnodes -- Get all nodes  
POST method : http://localhost:8000/api/users/import ---- importing CSV --- CSV file need to be 
uploaded for this api 

sample request body to add node: 
{ "nodeId": "123456789", "nodeName": "TestNode", "description": "This is a test description", "memo": 
"Test memo content", "nodeType": "Type1", "parentNodeGroupName": "ParentGroup", 
"parentNodeGroupId": "56789", "parentNode": "ParentNode1" } 

Steps to Upload a File Using Postman Open Postman: Launch the Postman application: 

Create a New Request: 

Click on the "New" button, then select "HTTP Request". Alternatively, click on the "New" tab and choose 
"Request" from the dropdown. Set the Request Method to POST: 
In the dropdown list next to the URL field, select POST. Enter the URL: 
Enter the URL for your endpoint in the address bar. http://44.211.158.225:8000/api/users/import  or 
http://localhost:8000/api/users/import  Add the File to the Request: 
Click on the "Body" tab below the address bar. Select the "form-data" option. You will see two fields: Key 
and Value. In the Key field, enter the name of the parameter that your Spring Boot controller is expecting 
(file in this case). In the Value field, select the dropdown and choose "File" instead of "Text". A "Select 
Files" button will appear. Click it and browse to select the file you want to upload. Send the Request: 
Click on the "Send" button to send the request to your Spring Boot application.
