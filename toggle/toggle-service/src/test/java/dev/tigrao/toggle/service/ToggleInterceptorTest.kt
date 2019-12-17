package dev.tigrao.toggle.service

import br.com.odete.network.authorization.AuthorizationHeaderFacade
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.odete.toggle.service.remote.ToggleRepository
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.junit.Test
import javax.net.ssl.HttpsURLConnection

class ToggleInterceptorTest {

    @Test
    fun givenAChain_ShouldProceedJustOneTime() {
        val authorizationHeaderFacade = mock<AuthorizationHeaderFacade> {
            on { hasRefreshToken(any()) } doReturn "hash"
        }
        val toggleInterceptor =
            ToggleInterceptor(authorizationHeaderFacade, lazy { mock<ToggleRepository>() })

        val request = Request.Builder()
            .url("http://google.com.br")
            .build()

        val response = Response.Builder()
            .code(HttpsURLConnection.HTTP_OK)
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .message("")
            .build()

        val chain = mock<Interceptor.Chain> {
            on { request() } doReturn request
            on { proceed(any()) } doReturn response
        }

        toggleInterceptor.intercept(chain)

        verify(chain).proceed(any())
    }

    @Test
    fun givenAHeaderWithRefreshToken_ShouldFetchToggles() {
        val authorizationHeaderFacade = mock<AuthorizationHeaderFacade> {
            on { hasRefreshToken(any()) } doReturn "hash"
        }
        val toggleRepository = mock<ToggleRepository>()
        val toggleInterceptor =
            ToggleInterceptor(authorizationHeaderFacade, lazy { toggleRepository })

        val request = Request.Builder()
            .url("http://google.com.br")
            .build()

        val response = Response.Builder()
            .code(HttpsURLConnection.HTTP_OK)
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .message("")
            .build()

        val chain = mock<Interceptor.Chain> {
            on { request() } doReturn request
            on { proceed(any()) } doReturn response
        }

        toggleInterceptor.intercept(chain)

        verify(toggleRepository).fetchTogglesFromRemote()
    }

    @Test
    fun givenAHeaderWithoutRefreshToken_ShouldNotFetchToggles() {
        val authorizationHeaderFacade = mock<AuthorizationHeaderFacade> {
            on { hasRefreshToken(any()) } doReturn ""
        }
        val toggleRepository = mock<ToggleRepository>()
        val toggleInterceptor =
            ToggleInterceptor(authorizationHeaderFacade, lazy { toggleRepository })

        val request = Request.Builder()
            .url("http://google.com.br")
            .build()

        val response = Response.Builder()
            .code(HttpsURLConnection.HTTP_OK)
            .request(request)
            .protocol(Protocol.HTTP_1_1)
            .message("")
            .build()

        val chain = mock<Interceptor.Chain> {
            on { request() } doReturn request
            on { proceed(any()) } doReturn response
        }

        toggleInterceptor.intercept(chain)

        verify(toggleRepository, never()).fetchTogglesFromRemote()
    }
}
