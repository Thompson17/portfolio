# Chess WebSocket Server – Java

## Overview

This code sample was developed as part of a university assignment on distributed systems during my Computer Science studies.

The assignment involved developing an online chess application with separate components for web clients, user management and game processing.

My contribution was the implementation of the web server component, which acts as an intermediary between browser-based clients and the remote game server.

## Demonstrated Concepts

- Client-server architecture
- Distributed systems
- Bidirectional WebSocket communication
- Remote Method Invocation (RMI)
- JSON message processing
- Session management
- Proxy and listener concepts
- Event-based communication
- Interface design and exception handling

## Implementation

### WebSocket Endpoint

The `GameServlet` class provides a WebSocket endpoint that receives client messages, processes requests and forwards relevant information to remote server components.

The supported requests include login, registration, logout, matchmaking, chess moves and resignation.

### Session Management

The `SessionData` class associates WebSocket connections with their corresponding RMI proxies.

### RMI Communication

The `IUserServer` interface defines remote operations for user management.

The `WebClientProxy` class receives remote callbacks from the game server and forwards them to the web server through the `WebClientProxyListener` interface.

This allows game-related events, such as opponent moves and changes in game status, to be communicated back to connected web clients.

## Technologies

- Java
- Jakarta WebSocket API
- Java RMI
- JSON (org.json)

## Authorship

I developed the web server component as part of the original academic assignment. The individual authorship of the shared RMI interface has not been separately established.

Minor technical corrections and documentation improvements were made during portfolio preparation in November 2026: concurrent session map access, handling of malformed JSON and missing game proxies, and safer callback listener access.

## Scope

This sample focuses on the web server component rather than the complete chess application.

The browser-based client, game server, user server and some supporting interfaces are not included.

The code is provided for review and illustration rather than as a complete, executable application. It has not been compiled, runtime-tested or comprehensively security-tested as part of the portfolio preparation.

## Technical Limitations

This academic implementation is intended to demonstrate communication between distributed software components rather than production-ready server architecture.

- The concurrent session map does not guarantee thread safety across all server operations.
- Shared RMI connection initialisation and concurrent WebSocket writes require further safeguards.
- Remote callback object disposal and logout-related session state management are not fully addressed.
- Diagnostic logging includes usernames and complete outgoing messages and would require further review before production use.
