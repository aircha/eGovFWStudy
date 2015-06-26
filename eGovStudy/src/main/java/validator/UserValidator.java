package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import user.vo.UserVO;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserVO user = (UserVO) target;
		if (user.getUserid() == null || user.getUserid().trim().isEmpty()) {
			errors.rejectValue("userid", "required", new Object[]{"userid"}, "your id is excepted!");
		}
		if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
			errors.rejectValue("username", "required", new Object[]{"username"}, "must input");
		}
		if (user.getUserpwd() == null || user.getUserpwd().trim().isEmpty()) {
			errors.rejectValue("userpwd", "required", new Object[]{"password"}, "must input");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required");
	}

}
