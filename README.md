```bash
┏━╸╻  ┏━┓┏━┓┏━┓╻┏━╸╻┏━╸┏━┓╺┳╸╻┏━┓┏┓╻┏━┓   ┏━┓┏━┓╻
┃  ┃  ┣━┫┗━┓┗━┓┃┣╸ ┃┃  ┣━┫ ┃ ┃┃ ┃┃┗┫┗━┓╺━╸┣━┫┣━┛┃
┗━╸┗━╸╹ ╹┗━┛┗━┛╹╹  ╹┗━╸╹ ╹ ╹ ╹┗━┛╹ ╹┗━┛   ╹ ╹╹  ╹
```
# classifications-api

This repository contains code to expose the ala-name-matching code as a REST service.

# Usage

		make docs  # render .html from .apib
		make up  # start mock server with API endpoints from .apib

		make test  # validate the mock server API (or other server) against the .apib
		make report  # validate .apib and generate report

		make clean 
		make down

