package fr.nimrod.ilv.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class FaceRecognitionResponse {

   private List<FaceRecognition> faces;
   
   public boolean addFace(FaceRecognition face){
      if(faces == null){
         faces = new ArrayList<>();
      }
      if(!faces.contains(face)){
         return faces.add(face);
      }
      return false;
   }
}
