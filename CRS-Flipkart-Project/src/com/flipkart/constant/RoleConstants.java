package com.flipkart.constant;

/**
 * @author JEDI-02
 */
public enum RoleConstants {
    ADMIN,PROFESSOR,STUDENT;

    /**
     * Method to get Role object from String
     * @param role
     * @return Role object
     */
    public static RoleConstants stringToName(String role)
    {
        RoleConstants userRole=null;

        if(role.equalsIgnoreCase("ADMIN"))
            userRole=RoleConstants.ADMIN;
        else if(role.equalsIgnoreCase("PROFESSOR"))
            userRole=RoleConstants.PROFESSOR;
        else if(role.equalsIgnoreCase("STUDENT"))
            userRole=RoleConstants.STUDENT;
        return userRole;
    }
}
