(sleep 30; gradle buildAndReload --continuous -PskipDownload=true -x Test)&
gradle bootRun --stacktrace -PskipDownload=true -Dspring.profiles.active=development