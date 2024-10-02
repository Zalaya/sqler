#!/bin/bash

BASE_DIRECTORY=$(cd "$(dirname "$0")/.." && pwd)

CLEAN_FRONTEND=true
CLEAN_BACKEND=true

while [[ "$#" -gt 0 ]]; do
    case $1 in
        -f|--frontend) CLEAN_FRONTEND=true; CLEAN_BACKEND=false ;;
        -b|--backend) CLEAN_BACKEND=true; CLEAN_FRONTEND=false ;;
        *) echo "Unknown parameter passed: $1"; exit 1 ;;
    esac
    shift
done

if [[ "$CLEAN_FRONTEND" = true ]]; then
    if command -v node > /dev/null 2>&1 && command -v npm > /dev/null 2>&1; then
        ( cd "$BASE_DIRECTORY/frontend" && rm -rf node_modules dist *.tsbuildinfo )
    fi
fi

if [[ "$CLEAN_BACKEND" = true ]]; then
    if command -v gradle > /dev/null 2>&1; then
        ( cd "$BASE_DIRECTORY/backend" && gradle clean )
    fi
fi