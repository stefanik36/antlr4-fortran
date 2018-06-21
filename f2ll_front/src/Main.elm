-- Read all about this program in the official Elm guide:
-- https://guide.elm-lang.org/architecture/user_input/text_fields.html


module Main exposing (..)

import Html exposing (Html, Attribute, program, text, div, input, textarea, button)
import Html.Attributes exposing (..)
import Html.Events exposing (onInput, onClick)
import Http
import Json.Encode as Encode exposing (object, string, encode)
import Json.Decode as Decode exposing (list)
import Bootstrap.Grid as Grid
import Bootstrap.CDN as CDN
import String


main =
    program
        { init = init, view = view, update = update, subscriptions = subscriptions }



--MODEL


type alias Model =
    { fortran : String, llvm : String, result : String }


type alias ResponseS =
    { llvm : String, result : String }


init =
    ( Model "" "" "", Cmd.none )



-- UPDATE


type Msg
    = NewContent String
    | Send
    | IpAddr (Result Http.Error ResponseS)


update msg model =
    case msg of
        NewContent content ->
            ( { model | fortran = content }, Cmd.none )

        Send ->
            ( model, getRandomGif model.fortran )

        IpAddr (Ok addr) ->
            ( { model | llvm = addr.llvm, result = addr.result }, Cmd.none )

        IpAddr (Err _) ->
            ( model, Cmd.none )



-- SUBSCRIPTIONS


subscriptions model =
    Sub.none



-- VIEW


view model =
    div []
        [ Grid.container []
            [ CDN.stylesheet
            , Grid.row []
                [ Grid.col []
                    [ Html.h1 [] [ text "Fortran to LLVM6 translator!" ]
                    ]
                ]
            , Grid.row []
                [ Grid.col []
                    [ div [ class "form-group" ]
                        [ Html.label [ for "insert_fortran" ] [ text "Fortran code:" ]
                        , textarea [ class "form-control", id "insert_fortran", rows 10, placeholder "insert code", onInput NewContent ] []
                        ]
                    ]
                ]
            , Grid.row []
                [ Grid.col []
                    [ div [ class "text-right" ]
                        [ button [ class "btn btn-success", style [ ( "margin-right", "15px" ), ( "margin-bottom", "15px" ) ], onClick Send ] [ text "Translate" ]
                        ]
                    ]
                ]
            , Grid.row []
                [ Grid.col []
                    [ Html.label [ for "output" ] [ text "LLVM result code:" ]
                    ]
                , Grid.col []
                    [ div [ class "text-right", (statusStyle model.result) ] [ text ("Status: " ++ model.result) ]
                    ]
                ]
            , Grid.row []
                [ Grid.col []
                    [ textarea [ readonly True, class "form-control", style [ ( "background-color", "white" ) ], id "output", rows 10, placeholder "Click on translate button to translate" ] [ text model.llvm ]
                    ]
                ]
            ]
        ]


getRandomGif str =
    let
        url =
            "http://localhost:8080/api/main/run"
    in
        Http.send IpAddr (Http.post url (body str) decodeResult)


body str =
    Http.jsonBody (Encode.object [ ( "fortranCode", Encode.string str ) ])


decodeResult =
    Decode.map2 ResponseS
        (Decode.at [ "llvm" ] Decode.string)
        (Decode.at [ "result" ] Decode.string)


statusStyle str =
    let
        margin_style =
            ( "margin-right", "20px" )
    in
        case str of
            "Ok" ->
                style [ ( "color", "green" ), margin_style ]

            "" ->
                style [ margin_style ]

            _ ->
                style [ ( "color", "red" ), margin_style ]


myStyle =
    style
        [ ( "white-space", "pre-wrap" )
        , ( "padding", "10px" )
        , ( "font-size", "1em" )
        , ( "border-width", "1px" )
        , ( "border-style", "solid" )
        , ( "border-color", "grey" )
        , ( "background-color", "white" )
        ]
