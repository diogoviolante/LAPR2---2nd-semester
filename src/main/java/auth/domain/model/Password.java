package auth.domain.model;

import app.domain.shared.Constants;
import at.favre.lib.crypto.bcrypt.BCrypt;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Objects;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Password implements Serializable {

    private String password;


    public Password(String password)
    {
        if (!validate(password))
            throw new IllegalArgumentException("Invalid Email Address.");
        this.password = createHash(password);
    }

    public static String generatePW(int length) {
        final String passwordUtils = Constants.VAL_PASS;

        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int car = secureRandom.nextInt(passwordUtils.length());
            stringBuilder.append(passwordUtils.charAt(car));
        }
        return stringBuilder.toString();
    }

    private boolean validate(String password) {
        if (StringUtils.isBlank(password))
            return false;
        // Check for other invalid criteria here

        //
        return true;
    }

    private String createHash(String password)
    {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST,password.toCharArray());
    }

    public boolean checkPassword(String pwd)
    {
        if (StringUtils.isBlank(pwd))
            return false;
        BCrypt.Result result = BCrypt.verifyer().verify(pwd.toCharArray(),this.password.toCharArray());
        return result.verified;
    }


    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 7 * hash + this.password.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        // Inspired in https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Password obj = (Password) o;
        return Objects.equals(this.password, obj.password);
    }

    @Override
    public String toString() {return password;}
}