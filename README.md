# chiral.computer

This is the code for [my portfolio site](http://chiral.computer). There is a [ring](https://github.com/ring-clojure/ring) server for development, but when I deploy the site I use [stasis](https://github.com/magnars/stasis) to generate static pages and serve them using Amazon s3.

Much of the site was developed in a test-driven style, writing the test before the code to pass it. I relied heavily on [this post](http://cjohansen.no/building-static-sites-in-clojure-with-stasis/) on deploying and optimizing a static web site. 
