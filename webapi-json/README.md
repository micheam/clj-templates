# webapi-json

A clj template for json webapi.

## Usage

```bash
$ clj -Sdeps '{:deps
              {seancorfield/clj-new
                {:mvn/version "0.7.8"}}}' \
  -m clj-new.create \
  https://github.com/micheam/clj-templates/webapi-json@8111017566a4f7b8e2d457df01cd564ea622a88c \
  yourname/appname
```

Project will be created under `appname` directory.
So, you can run it below:

```
$ cd appname
$ clj -m yourname.appname
```

Server will start on port 8080:

```
$ curl localhost:8080
Hello, World
```

