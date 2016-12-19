package fr.nimrod.ilv.services.kairos.model.api.detect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class KairosImageDetect {

   private String status;
   
   private String file;
   
   private int width;
   
   private int height;
   
   private List<KairosFace> faces;
   
}
