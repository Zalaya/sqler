rootProject.name = "sqler"

include("sqler-rest-api")

include(
    "sqler-rest-api:sqler-rest-api-application",
    "sqler-rest-api:sqler-rest-api-domain",
    "sqler-rest-api:sqler-rest-api-infrastructure",
)
