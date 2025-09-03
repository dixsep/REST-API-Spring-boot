package com.vishal.learnRESTAPIs;

public class Notes {


    /*
		  controller : handles api requests, here is where we define APIs
		  repo : this layer interacts with the Data Base
		  service : this layer has business logic.
	*/

    /*
      Rest controller : controller (helpful in the API mapping)  + response body (return type is JSON)
      dispatcher servlet : routes the request, decides controller nd method

      model : normal Java Object  (return by controller)
      HTTP msg converter : java object to json object

      dispatcher servlet writes to HttpServletResponse
     */

    /*
          Seperation of Concern :

          C   --(DTO)-->  S -- (Entity) -->  R

          C  <--- (DTO) ----  S  <-- (Entity) --- R
     */

    /*
       Response Entity : we can say the status code, body etc
     */
}
