package fr.nimrod.ilv.services.kairos.model.api.detect;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.nimrod.ilv.services.kairos.model.api.enroll.KairosAttribute;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL) 
public class KairosFace {

   private int topLeftX;
   
   private int topLeftY;
   
   private int width;
   
   private int height;
   
   private int leftEyeCenterX;
   
   private int leftEyeCenterY;
   
   private int rightEyeCenterX;
   
   private int chinTipX;
   
   private int chinTipY;
   
   private int pitch;
   
   private int yaw;
   
   private int roll;
   
   private double confidence;
   
   @JsonProperty("face_id")
   private int idFace;
   
   private KairosAttribute attributes;
   
}
