# News24
The goal is to create a News Feed app which gives a user regularly-updated news from the Internet related to a particular topic, person, or location.  Its fetch data from theguardian

## MEETS SPECIFICATIONS

->App contains a main screen which displays multiple news stories


->Each list item on the main screen displays relevant text and information about the story.


->The title of the article and the name of the section that it belongs to are required field.


->If available, author name and date published should be included. Please note not all responses will contain these pieces of data, but it is required to include them if they are present.


->Images are not required.


## FUNCTIONALITY

->Stories shown on the main screen update properly whenever new news data is fetched from the API.


->Clicking on a story uses an intent to open the story in the user’s browser.


->App queries the content.guardianapis.com api to fetch news stories related to the topic chosen by the student, using either the ‘test’ api key or the student’s key.


->The JSON response is parsed correctly, and relevant information is stored in the app.

->When there is no data to display, the app shows a default TextView that informs the user.

->The app checks whether the device is connected to the internet and responds appropriately. The result of the request is validated to account for a bad server response or lack of server response.


->Networking operations are done using a Loader rather than an AsyncTask.


->The intent of this project is to give you practice writing raw Java code using the necessary classes provided by the Android framework; therefore, the use of external libraries for the core functionality will not be permitted to complete this project.


->The student must use a Uri builder to construct the URL string to pass into the Loader constructor.




![news1](https://user-images.githubusercontent.com/45606322/51956589-7cdff800-2405-11e9-9f56-0be9e903f726.png)

![news2](https://user-images.githubusercontent.com/45606322/51957144-a568f180-2407-11e9-8892-8155e61ca5d7.png)
