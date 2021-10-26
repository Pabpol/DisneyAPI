package com.AlkemyChallenge.DinseyAPI.secvices;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.AlkemyChallenge.DinseyAPI.appUser.AppUserRole;
import com.AlkemyChallenge.DinseyAPI.modelDTO.AppUser;
import com.AlkemyChallenge.DinseyAPI.modelDTO.ConfirmationToken;
import com.AlkemyChallenge.DinseyAPI.registration.EmailValidator;
import com.AlkemyChallenge.DinseyAPI.registration.RegistrationsRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private final AppUserService appUserService;
	private final EmailValidator emailValidator;
	private final ConfirmationTokenService confirmationTokenService;
	
	public String register(RegistrationsRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		
		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
			
		}
		return appUserService.signUpUser(
				
				new AppUser(
						request.getFirstName(),
						request.getLastName(),
						request.getEmail(),
						request.getPassword(),
						AppUserRole.USER
						
						)				
				);
	}
	
	  @Transactional
	    public String confirmToken(String token) {
	        ConfirmationToken confirmationToken = confirmationTokenService
	                .getToken(token)
	                .orElseThrow(() ->
	                        new IllegalStateException("token not found"));

	        if (confirmationToken.getConfirmedAt() != null) {
	            throw new IllegalStateException("email already confirmed");
	        }

	        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

	        if (expiredAt.isBefore(LocalDateTime.now())) {
	            throw new IllegalStateException("token expired");
	        }

	        confirmationTokenService.setConfirmedAt(token);
	        appUserService.enableAppUser(
	                confirmationToken.getAppUser().getEmail());
	        return "confirmed";
	    }

}
