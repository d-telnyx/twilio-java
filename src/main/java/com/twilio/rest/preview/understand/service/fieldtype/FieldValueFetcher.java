/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.understand.service.fieldtype;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class FieldValueFetcher extends Fetcher<FieldValue> {
    private final String pathServiceSid;
    private final String pathFieldTypeSid;
    private final String pathSid;

    /**
     * Construct a new FieldValueFetcher.
     * 
     * @param pathServiceSid The service_sid
     * @param pathFieldTypeSid The field_type_sid
     * @param pathSid The sid
     */
    public FieldValueFetcher(final String pathServiceSid, 
                             final String pathFieldTypeSid, 
                             final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathFieldTypeSid = pathFieldTypeSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched FieldValue
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public FieldValue fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            "/understand/Services/" + this.pathServiceSid + "/FieldTypes/" + this.pathFieldTypeSid + "/FieldValues/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("FieldValue fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return FieldValue.fromJson(response.getStream(), client.getObjectMapper());
    }
}