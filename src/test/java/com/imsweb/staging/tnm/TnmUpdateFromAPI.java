package com.imsweb.staging.tnm;

import java.io.IOException;

import com.imsweb.staging.UpdaterUtils;

/**
 * Update the CS data from the API
 */
public class TnmUpdateFromAPI {

    private static final String _ALGORITHM = "tnm";
    private static final String _VERSION = "1.3";

    public static void main(String[] args) throws IOException {
        UpdaterUtils.update(_ALGORITHM, _VERSION);
    }

}
