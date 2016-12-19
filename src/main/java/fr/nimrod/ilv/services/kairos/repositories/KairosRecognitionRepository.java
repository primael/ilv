package fr.nimrod.ilv.services.kairos.repositories;

import java.util.Arrays;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.nimrod.ilv.services.kairos.model.api.KairosDetectRequest;
import fr.nimrod.ilv.services.kairos.model.api.KairosDetectResponse;
import fr.nimrod.ilv.services.kairos.model.api.KairosEnrollRequest;
import fr.nimrod.ilv.services.kairos.model.api.KairosEnrollResponse;
import fr.nimrod.ilv.services.kairos.model.api.KairosRecognizeRequest;
import fr.nimrod.ilv.services.kairos.model.api.KairosRecognizeResponse;

@Repository
public class KairosRecognitionRepository {

   @Value("${kairos.api.id}")
   private String apiId;
   
   @Value("${kairos.api.key}")
   private String apiKey;
   
   @Autowired
   private RestTemplate restTemplate;
   
   @Async
   public Future<ResponseEntity<KairosEnrollResponse>> enroll(KairosEnrollRequest request){
      
      HttpHeaders requestHeaders = createHeaders();
      
      HttpEntity<KairosEnrollRequest> entity = new HttpEntity<KairosEnrollRequest>(request, requestHeaders);
      
      ResponseEntity<KairosEnrollResponse> futureEntity = restTemplate.postForEntity("https://api.kairos.com/enroll", entity, KairosEnrollResponse.class);
            
      return new AsyncResult<>(futureEntity);
      
   }

   @Async
   public Future<ResponseEntity<KairosRecognizeResponse>> recognize(KairosRecognizeRequest request){
      
      HttpHeaders requestHeaders = createHeaders();
      
      HttpEntity<KairosRecognizeRequest> entity = new HttpEntity<KairosRecognizeRequest>(request, requestHeaders);
      
      ResponseEntity<KairosRecognizeResponse> futureEntity = restTemplate.postForEntity("https://api.kairos.com/recognize", entity, KairosRecognizeResponse.class);
      
      return new AsyncResult<>(futureEntity);
   }
   
   @Async
   public Future<ResponseEntity<KairosDetectResponse>> detect(KairosDetectRequest request){
      
      HttpHeaders requestHeaders = createHeaders();
      
      HttpEntity<KairosDetectRequest> entity = new HttpEntity<KairosDetectRequest>(request, requestHeaders);
      
      ResponseEntity<KairosDetectResponse> futureEntity = restTemplate.postForEntity("https://api.kairos.com/detect", entity, KairosDetectResponse.class);
      
      return new AsyncResult<>(futureEntity);
   }

   private HttpHeaders createHeaders() {
      HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.add("app_id", apiId);
      requestHeaders.add("app_key", apiKey);
      requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      return requestHeaders;
   }
}
