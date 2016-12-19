package fr.nimrod.ilv.services.kairos.model.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.nimrod.ilv.services.kairos.model.api.detect.KairosImageDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_NULL)
public class KairosDetectResponse {

   private List<KairosImageDetect> images;
   
}
