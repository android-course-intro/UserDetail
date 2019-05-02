package kz.kyrmyzyanik.userdetail.data.gateway

/**
 * This interface executes and defines request's result whether it's Success or Error.
 */

sealed class ApiResponse {
    object Success : ApiResponse()
    object Error : ApiResponse()
}
