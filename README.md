# Colab by TechDivas

# Theme:
Collaborative Shopping Experience

# Problem Statement:
One of the things that differs from online vs offline shopping experience is “shopping together”. This void of company in online shopping can make it boring over a period of time. Ever wondered how collaborative shopping can improve shopping experience? Imagine you get to seek your friend’s style tips/suggestions on the go.

# Description of the Problem:

*	Need for a platform to mix virtual experience with the offline experience to engage users and improve monotonous online shopping experience.

*	A mutually rewarding buying and selling experience for both retailers and customers.

# Quick Links

# Proposed Solution


The idea is to make an android application where multiple users can shop together and get shared experience just like traditional shopping.

We aim to replicate the instore experience with family and friends, in comfort of home
Customized Product Catalogue:<br>
Personalized Customer product feed based on:<br>
*	Past shop and search history<br>
*	Recommendations and Suggestions from family/friends<br>
*	Items from family/friends Wishlist or cart<br>

Every product in feed offers a 3D view to know about it in – and – out.<br>
Virtual try-on of clothes/ accessories to pick the best<br>
Receive suggestions of complementing products to add to the look; similar as in a physical store with a virtual salesperson<br>
Share virtual outfit look with family/friends to seek advice<br>

# Tech Stack Used

* A native mobile application using Android SDK and Java<br>
* The AR features are developed using Unity Engine and C# programming.<br> 
* Google's AR core SDK for unity provides face detection. It is included as a package inside unity. The recorder/ capture is controlled by C# script. <br>
* For the 3D view of the products is obtained by making the camera face a plane where the floor is recommended. When the plane is detected, the user can see the 3D version of the product selected. The user can have a 360° view of the product.<br>
* Recommendation system using sklearn based on content based and collaborative filtering<br>
* API deployed on Heroku cloud is used for getting Responses<br>
* These responses are fetched by the Android app using Volley.
* Corresponsing details of each product are retrieved from the Firebase Database.
* Users are registered on the app via Firebase Authentication.
* User data regarding wishlist, cart and suggestions are stored in Firebase Firestore Database.
* IBM Watson chatbot is used to make virtual salesperson chatbot.<br>

# Screenshots

<table>
	<tr>
    <td> <img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia6651674199595905088.png"  alt="1" width = 360px height = 640px ></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia5897806593753510113.png" alt="2" width = 360px height = 640px></td>	
    <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia4334451049220496791.png" alt="2" width = 360px height = 640px></td>
   </tr> 
  <tr>
    <td> <img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia2221552480820006616.png"  alt="1" width = 360px height = 640px ></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia3964943662899712685.png" alt="2" width = 360px height = 640px></td>	
    <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia3806382942996388000.png" alt="2" width = 360px height = 640px></td>
   </tr> 
   <tr>
      <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia3549763234244386519.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Colab---TechDivas/blob/main/Screenshots/tia6712605497415806090%20(1).png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia7964814500322494698.png" align="right" alt="4" width = 360px height = 640px>
  </td>
  </tr>
  
  <tr>
      <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia6245132865850652994.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia686552637052219349.png" alt="3" width = 360px height = 640px></td>
<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia7387612660504003055.png" align="right" alt="4" width = 360px height = 640px>
  </td>
  </tr>
  <tr>
      <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia5845211807223843542.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia6636600915729832206.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia7911555231965264560.png" align="right" alt="4" width = 360px height = 640px>
  </td>
  </tr>
   <tr>
      <td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia2708697010745606050.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia521660018970833680.png" alt="3" width = 360px height = 640px></td>
	<td><img src="https://github.com/sanchi0204/Myntra_Hackerramp_TechDivas/blob/main/Screenshots/tia2881736521232471500.png" align="right" alt="4" width = 360px height = 640px>
  </td>
  </tr>
</table>

# Implementation of Machine Learning Model

* We are using amazon review dataset containing two files:<br>
      ratings_Clothing_Shoes_and_Jewelry.csv<br>
      metadata_ratings_Clothing_Shoes_and_Jewelry.csv<br>
      <link>https://jmcauley.ucsd.edu/data/amazon/ <br>    
* We merge the two dataset and  perform data visualization and data cleaning<br>
* Then we generate two machine learning models based on popularity based filtering and collaborative filtering<br>
* By comparing root mean square error of different algorithm we comes to a conclusion of using KNN model for prediction<br>
* save it as a pickle file and deploy it on heroku!


# Impact

* Customized product catalogue provides adaptation to customer’s buying behaviour and market trends to maintain Freshness & wow factor in shopping experience.<br>
* Virtual trial rooms and 3D view of products provide visually stimulating and personalized shopping journey<br>
* Customers can interact and engage with people in their trusted circle for product selection and purchase.<br>
* Online shopping is no more a lonely affair<br>
* Aids a right and quick product selection without going through overabundance of product listings.<br>
* Increased customer satisfaction and engagement<br>
* Near to real experience<br>
* Enables online retailers to replicate the thrills of an in-store , fulfilling experience<br>

# Contributors

* [Sanchi Rastogi](https://github.com/sanchi0204)
* [Isha Mudgal](https://github.com/Ishamudgalll)
* [Saumya Bathla](https://github.com/saumyabathla)
