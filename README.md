<img src="/assets/images/Logo.png?raw=true" align="left" hspace="1" vspace="1">

# OpenCI

[![Discord](https://img.shields.io/badge/discord-join-red.svg)](https://discord.gg/B6QVMmS)
[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

**Open-source** Travis CI client built from ground zero.

Ever wished of triggering or sharing those code tests right from your mobilde device? Well, OpenCI does just that. Now test and deploy with confidence with Travis CI on the go.

## Screenshots

| Login | Feeds |
|:-:|:-:|
| ![Login](/assets/images/Login.png?raw=true) | ![Feeds](/assets/images/Feeds.png?raw=true) |

_OpenCI is actively developed. More features will come!_

## Contributions Best Practices

### Branch Policy

We have the following branches

 * **development** All development goes on in this branch. If you're making a contribution, you are supposed to make a pull request to _development_.
 * **master** This contains shipped code. After significant features/bugfixes are accumulated on development, we make a version update and make a release.

 ### Code practices

Please help us follow the best practice to make it easy for the reviewer as well as the contributor. We want to focus on the code quality more than on managing pull request ethics.

 * Single commit per pull request
 * For writing commit messages please read the [COMMITSTYLE](/assets/commitStyle.md) carefully. Kindly adhere to the guidelines.
 * Follow uniform design practices. The design language must be consistent throughout the app.
 * The pull request will not get merged until and unless the commits are squashed. In case there are multiple commits on the PR, the commit author needs to squash them and not the maintainers cherrypicking and merging squashes.
 * If the PR is related to any front end change, please attach relevant screenshots in the pull request description.

 ### Join the development

* Before you join development, please set up the project on your local machine, run it and go through the application completely. Press on any button you can find and see where it leads to. Explore. (Don't worry ... Nothing will happen to the app or to you due to the exploring :wink: Only thing that will happen is, you'll be more familiar with what is where and might even get some cool ideas on how to improve various aspects of the app.)
* If you would like to work on an issue, drop in a comment at the issue. If it is already assigned to someone, but there is no sign of any work being done, please free to drop in a comment so that the issue can be assigned to you if the previous assignee has dropped it entirely.

## Libraries in Use

- [**Retrofit**](https://github.com/square/retrofit) for constructing the REST API
- [**Picasso**](https://github.com/square/picasso) for loading images
- [**Gson**](https://github.com/google/gson) to convert Java objects to JSON and vice-versa
- [**Gson Converter**](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) for serialization to and from JSON

## License

> Copyright (C) 2017 Brijesh  
> Licensed under the [GPL-3.0](https://www.gnu.org/licenses/gpl.html) license (See the [LICENSE](https://github.com/brijeshshah13/OpenCI/blob/master/LICENSE) file for the whole license text)