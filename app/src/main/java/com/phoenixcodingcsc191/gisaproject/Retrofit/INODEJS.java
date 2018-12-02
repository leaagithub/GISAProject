package com.phoenixcodingcsc191.gisaproject.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INODEJS {
    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(
            @Field("eid") String eid,
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("phoneno") String phoneno,
            @Field("password") String password,
            @Field("email") String email);

    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("eid") String eid,
                                 @Field("password") String password);

    @POST("submitIncidentReport")
    @FormUrlEncoded
    Observable<String> submitIncidentReport(
            @Field("DateOfIncident") String DateOfIncident,
            @Field("DateOfReport") String DateOfReport,
            @Field("District") String District,
            @Field("County") String County,
            @Field("Route") String Route,
            @Field("Latitude") String Latitude,
            @Field("Longitude") String Longitude,
            @Field("Observation") String Observation,
            @Field("EmployeeID") String EmployeeID,
            @Field("Distribution") String Distribution,
            @Field("HighwayStatus") String HighwayStatus,
            @Field("ClosedLanes") String ClosedLanes,
            @Field("WaterContent") String WaterContent,
            @Field("AdjacentUtilities") String AdjacentUtilities,
            @Field("AdjacentProperties") String AdjacentProperties,
            @Field("Sketch") String Sketch,
            @Field("Photos") String Photos);

    @POST("submitMaterial")
    @FormUrlEncoded
    Observable<String> submitMaterial(
            @Field("TypeOfMaterial") String TypeOfMaterial,
            @Field("Bedding") String Bedding,
            @Field("Joints") String Joints,
            @Field("Fractures") String Fractures,
            @Field("Clay") String Clay,
            @Field("Silt") String Silt,
            @Field("Sand") String Sand,
            @Field("Gravel") String Gravel);

    @POST("submitFollowUpActions")
    @FormUrlEncoded
    Observable<String> submitFollowUpActions(
            @Field("FollowUpActions") String FollowUpActions,
            @Field("OpenLines") String OpenLines);

    @POST("submitImmediateActions")
    @FormUrlEncoded
    Observable<String> submitImmediateActions(
            @Field("ImmediateActions") String ImmediateActions,
            @Field("OpenLines") String OpenLines);

    @POST("submitIncidentType")
    @FormUrlEncoded
    Observable<String> submitIncidentType(
            @Field("IncidentType") String IncidentType);
    @POST("submitMeasurements")
    @FormUrlEncoded
    Observable<String> submitMeasurements(
            @Field("SlopeHeight_ft") String SlopeHeight_ft,
            @Field("OriginalSlope_deg") String OriginalSlope_deg,
            @Field("LandslideWidth_ft") String LandslideWidth_ft,
            @Field("LandslideLength_ft") String LandslideLength_ft,
            @Field("MainScarpHeight_ft") String MainScarpHeight_ft,
            @Field("LandslideSlope_deg") String LandslideSlope_deg,
            @Field("LengthOfRoadwayEncroached_ft") String LengthOfRoadwayEncroached_ft,
            @Field("WidthOfRoadwayEncroached_ft") String WidthOfRoadwayEncroached_ft);
    @POST("submitPavement_Ground_Status")
    @FormUrlEncoded
    Observable<String> submitPavement_Ground_Status(
            @Field("PavementGroundCracks") String PavementGroundCracks,
            @Field("CrackLength_feet") String CrackLength_feet,
            @Field("CrackHorisontalDisposiion_inch") String CrackHorisontalDisposiion_inch,
            @Field("CrackVerticalDisposiion_inch") String CrackVerticalDisposiion_inch,
            @Field("DepthOfCrack_inch") String DepthOfCrack_inch,
            @Field("Settlement_inch") String Settlement_inch,
            @Field("Bulge_inch") String Bulge_inch,
            @Field("IndentedByRocks") String IndentedByRocks);
    @POST("submitVegetationOnSlope")
    @FormUrlEncoded
    Observable<String> submitVegetationOnSlope(
            @Field("Trees") String Trees,
            @Field("Bushes_Shrubs") String Bushes_Shrubs,
            @Field("GroundCover") String GroundCover);
    @POST("submitWater_Drainage")
    @FormUrlEncoded
    Observable<String> submitWater_Drainage(
            @Field("Water_Drainage") String Water_Drainage);
}