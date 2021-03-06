/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.numbers.v2.regulatorycompliance.bundle;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ItemAssignmentFetcher extends Fetcher<ItemAssignment> {
    private final String pathBundleSid;
    private final String pathSid;

    /**
     * Construct a new ItemAssignmentFetcher.
     *
     * @param pathBundleSid The unique string that identifies the resource.
     * @param pathSid The unique string that identifies the resource
     */
    public ItemAssignmentFetcher(final String pathBundleSid,
                                 final String pathSid) {
        this.pathBundleSid = pathBundleSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched ItemAssignment
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ItemAssignment fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.NUMBERS.toString(),
            "/v2/RegulatoryCompliance/Bundles/" + this.pathBundleSid + "/ItemAssignments/" + this.pathSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ItemAssignment fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ItemAssignment.fromJson(response.getStream(), client.getObjectMapper());
    }
}