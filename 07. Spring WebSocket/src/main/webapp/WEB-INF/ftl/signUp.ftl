<!doctype html>
<html>
<head>
    <link rel="stylesheet" href="/resources/style/style.css">
    <title>SigUp</title>
</head>
<body>
<div class="form-style-3">
    <form method="post">
        <fieldset>
            <#if registrationStatus??>
                ${registrationStatus}
            </#if>
            <legend>Sign Up</legend>
            <label for="firstName"><span>First Name<span class="required">*</span></span><input type="text"
                                                                                                class="input-field"
                                                                                                name="firstName"
                                                                                                value=""/></label>
            <br>
            <label for="lastName"><span>Last Name <span class="required">*</span></span><input type="text"
                                                                                               class="input-field"
                                                                                               name="lastName"
                                                                                               value=""/></label>
            <br>
            <label for="email"><span>Email <span class="required">*</span></span><input type="email"
                                                                                        class="input-field"
                                                                                        name="email"
                                                                                        value=""/></label>
            <br>
            <label for="password"><span>Password<span class="required">*</span></span><input type="password"
                                                                                             class="input-field"
                                                                                             name="password"
                                                                                             value=""/></label>
            <br>
            <label for="confirmPassword"><span>Confirm Password<span class="required">*</span></span><input type="password"
                                                                                             class="input-field"
                                                                                             name="confirmPassword"
                                                                                             value=""/></label>
            <br>
            <label for="gender"><span>Gender<span class="required">*</span></span>
                Male<input type="radio" class="input-field" name="gender" value="MALE"/>
                Female<input type="radio" class="input-field" name="gender" value="FEMALE"/>
                Unknown<input type="radio" class="input-field" name="gender" value="UNKNOWN"/>
            </label>
            <br>
            <label for="consent"><span>Consent<span class="required">*</span></span><input type="checkbox" class="input-field"
                                                                                                            name="consent"
                                                                                                            value="true"/></label>
            <br>
        </fieldset>
        <fieldset>
            <label><span> </span><input type="submit" value="Submit"/></label>
        </fieldset>
    </form>
    
</div>

</body>
</html>