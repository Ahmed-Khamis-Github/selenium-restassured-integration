package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import com.qacart.todo.utilities.ConfigUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {

    public void addTask(String token)
    {
        Task task = new Task(false,"Learn") ;


      Response res =  given().baseUri(ConfigUtils.getInstance().getBaseUrl())
                .contentType("application/json")
                .body(task)
                .auth().oauth2(token)
              .log().all()
                .when()
                .post(EndPoint.API_TASK_ENDPOINT)
                .then().log().all()
                .extract().response() ;

      if (res.statusCode() != 201)
      {
          throw new RuntimeException("Failed to add new task") ;
      }
    }
}
