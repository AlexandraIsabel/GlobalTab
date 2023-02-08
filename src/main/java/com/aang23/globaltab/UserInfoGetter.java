package com.aang23.globaltab;



public class UserInfoGetter {
    public static String getPrefixFromUsername(String username) {
        if (GlobalTab.server.getPluginManager().isLoaded("luckperms")) {
            if (null != GlobalTab.luckpermsapi.getUserManager().getUser(username)) {
                if (GlobalTab.luckpermsapi.getUserManager().getUser(username).getCachedData().getMetaData().getPrefix() != null)
                    return GlobalTab.luckpermsapi.getUserManager().getUser(username).getCachedData().getMetaData().getPrefix().toString();
                else
                    return "";
            } else
                return "";
        } else
            return "";
    }

    public static String getSuffixFromUsername(String username) {
        if (GlobalTab.server.getPluginManager().isLoaded("luckperms")) {
            if (null != GlobalTab.luckpermsapi.getUserManager().getUser(username)) {
                if (GlobalTab.luckpermsapi.getUserManager().getUser(username).getCachedData().getMetaData().getSuffix() != null)
                    return GlobalTab.luckpermsapi.getUserManager().getUser(username).getCachedData().getMetaData().getSuffix().toString();
                else
                    return "";
            } else
                return "";
        } else
            return "";
    }
}