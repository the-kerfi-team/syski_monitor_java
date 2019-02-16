package uk.co.syski.client.WebSocket;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * A factory class which creates an {@link SSLContext} that
 * naively accepts all certificates without verification.
 *
 * <pre>
 * // Create an SSL context that naively accepts all certificates.
 * SSLContext context = NaiveSSLContext.getInstance("TLS");
 *
 * // Create a socket factory from the SSL context.
 * SSLSocketFactory factory = context.getSocketFactory();
 *
 * // Create a socket from the socket factory.
 * SSLSocket socket = factory.createSocket("www.example.com", 443);
 * </pre>
 *
 * @author Takahiko Kawasaki
 */
public class NaiveSSLContext
{
    private NaiveSSLContext()
    {
    }


    /**
     * Get an SSLContext that implements the specified secure
     * socket protocol and naively accepts all certificates
     * without verification.
     */
    public static SSLContext getInstance(String protocol) throws NoSuchAlgorithmException
    {
        return init(SSLContext.getInstance(protocol));
    }


    /**
     * Get an SSLContext that implements the specified secure
     * socket protocol and naively accepts all certificates
     * without verification.
     */
    public static SSLContext getInstance(String protocol, Provider provider) throws NoSuchAlgorithmException
    {
        return init(SSLContext.getInstance(protocol, provider));
    }


    /**
     * Get an SSLContext that implements the specified secure
     * socket protocol and naively accepts all certificates
     * without verification.
     */
    public static SSLContext getInstance(String protocol, String provider) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        return init(SSLContext.getInstance(protocol, provider));
    }


    /**
     * Set NaiveTrustManager to the given context.
     */
    private static SSLContext init(SSLContext context)
    {
        try
        {
            // Set NaiveTrustManager.
            context.init(null, new TrustManager[] { new NaiveTrustManager() }, null);
        }
        catch (KeyManagementException e)
        {
            throw new RuntimeException("Failed to initialize an SSLContext.", e);
        }

        return context;
    }


    /**
     * A {@link TrustManager} which trusts all certificates naively.
     */
    private static class NaiveTrustManager implements X509TrustManager
    {
        @Override
        public X509Certificate[] getAcceptedIssuers()
        {
            return null;
        }


        public void checkClientTrusted(X509Certificate[] certs, String authType)
        {
        }


        public void checkServerTrusted(X509Certificate[] certs, String authType)
        {
        }
    }
}
