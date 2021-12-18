package com.iit.imprimerie.exception;


import feign.Response;
import feign.codec.ErrorDecoder;


public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response reponse) {

        if(reponse.status() == 400 ) {
            return new NotFoundException(
                    "Requête incorrecte "
            );
        }

        else if (reponse.status() == 404 ) {
            return new NotFoundException(
                    "Ens non trouvé "
            );
        }

        return defaultErrorDecoder.decode(invoqueur, reponse);
    }

}


