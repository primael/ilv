package fr.nimrod.ilv.services.kairos.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class KairosRecognizeRequest {

   private String image;
   
   @JsonProperty("gallery_name")
   private String galleryName;
}
