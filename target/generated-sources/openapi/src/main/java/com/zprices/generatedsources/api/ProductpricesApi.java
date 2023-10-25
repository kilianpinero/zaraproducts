/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.zprices.generatedsources.api;

import com.zprices.generatedsources.model.Error;
import com.zprices.generatedsources.model.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-10-25T21:54:07.947335400+02:00[Europe/Madrid]")
@Validated
@Tag(name = "productprices", description = "the productprices API")
public interface ProductpricesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /productprices : 
     * get product prices
     *
     * @param applyDate applyDate (required)
     * @param productId productId (required)
     * @param brandId brandId (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Server Internal Error (status code 500)
     */
    @Operation(
        operationId = "getProducts",
        summary = "",
        tags = { "productprices" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Server Internal Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/productprices",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Product>> getProducts(
        @NotNull @Parameter(name = "applyDate", description = "applyDate", required = true) @Valid @RequestParam(value = "applyDate", required = true) String applyDate,
        @NotNull @Parameter(name = "productId", description = "productId", required = true) @Valid @RequestParam(value = "productId", required = true) Integer productId,
        @NotNull @Parameter(name = "brandId", description = "brandId", required = true) @Valid @RequestParam(value = "brandId", required = true) Integer brandId
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"end_date\" : \"end_date\", \"price_list\" : 1, \"price\" : 35.5, \"product_id\" : 1, \"brand_id\" : 35455, \"start_date\" : \"start_date\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
