import Common from "./../common/package";

class FuzzyKnightsClient {
	constructor(server, port) {
		this.Server = server;
		this.Port = port;
		this.UUID = Math.random();	//TODO Make an actual UUID from function
	}
}