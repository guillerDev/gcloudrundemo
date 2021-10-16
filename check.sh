echo "Project id: $PROJECT_ID"
echo "Repository name: $REPO_NAME"
{
  echo "Running test on $BRANCH_NAME"
  ./gradlew check
} || {
  echo "Gradle task check has failed"
}

if [ -n "$COMMIT_SHA" ]; then
  echo "Reports will be available at:"
  path="https://storage.googleapis.com/$BUCKET_NAME/$BRANCH_NAME/$COMMIT_SHA/index.html"
  echo "$path" > output.txt
  echo "$path"
  else
    echo "Not running in gcloud build environment!!"
fi
