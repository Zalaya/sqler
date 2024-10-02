#!/bin/bash

BASE_DIRECTORY=$(cd "$(dirname "$0")/.." && pwd)

BUILD_FRONTEND=true
BUILD_BACKEND=true

while [[ "$#" -gt 0 ]]; do
    case $1 in
        -f|--frontend) BUILD_FRONTEND=true; BUILD_BACKEND=false ;;
        -b|--backend) BUILD_BACKEND=true; BUILD_FRONTEND=false ;;
        *) echo "Unknown parameter passed: $1"; exit 1 ;;
    esac
    shift
done

if [[ $BUILD_FRONTEND = true ]]; then
    if command -v node > /dev/null 2>&1 && command -v npm > /dev/null 2>&1; then
        ( cd "$BASE_DIRECTORY/frontend" && npm install && npm run build )
    fi
fi

if [[ $BUILD_BACKEND = true ]]; then
    if command -v gradle > /dev/null 2>&1; then
        ( cd "$BASE_DIRECTORY/backend" && gradle build )
    fi
fi