package fr.nimrod.ilv.controllers;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nimrod.ilv.controllers.dto.FaceRecognition;
import fr.nimrod.ilv.controllers.dto.FaceRecognitionResponse;
import fr.nimrod.ilv.controllers.dto.ImageUriRequest;
import fr.nimrod.ilv.services.kairos.model.api.KairosDetectRequest;
import fr.nimrod.ilv.services.kairos.model.api.KairosDetectResponse;
import fr.nimrod.ilv.services.kairos.model.api.detect.KairosFace;
import fr.nimrod.ilv.services.kairos.model.api.detect.KairosImageDetect;
import fr.nimrod.ilv.services.kairos.repositories.KairosRecognitionRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FaceManipulationController {

   @Autowired
   private KairosRecognitionRepository repository;

   @PostMapping(value = "/recognize", produces = "application/json")
   public FaceRecognitionResponse postFaceForRecognition(ImageUriRequest imageURI)
         throws InterruptedException, ExecutionException {
      log.debug("Calling to recognition with data uri {}", imageURI.getData());

//      KairosDetectRequest request = new KairosDetectRequest();
//      request.setImage(imageURI.getData());
//      Future<ResponseEntity<KairosDetectResponse>> response = repository.detect(request);
//
//      while (!response.isDone()) {
//         Thread.sleep(100);
//      }
//
//      FaceRecognitionResponse toReturn = new FaceRecognitionResponse();
//
//      if (response.get().getStatusCode().is2xxSuccessful()) {
//         log.debug("Call success");
//         log.debug("response : " + response.get().getBody().getImages().size());
//
//         for (KairosImageDetect imageDetect : response.get().getBody().getImages()) {
//            for (KairosFace face : imageDetect.getFaces()) {
//               FaceRecognition faceRecognition = new FaceRecognition();
//               faceRecognition.setAge(face.getAttributes().getAge());
//               faceRecognition.setGenre(face.getAttributes().getGender().getType().equals("M") ? "Homme" : "Femme");
//               toReturn.addFace(faceRecognition);
//            }
//         }
//      }

       FaceRecognitionResponse toReturn = new FaceRecognitionResponse();
       FaceRecognition faceRecognition = new FaceRecognition();
       faceRecognition.setAge(35);
       faceRecognition.setGenre("Homme");
       toReturn.addFace(faceRecognition);

      return toReturn;
   }
}
