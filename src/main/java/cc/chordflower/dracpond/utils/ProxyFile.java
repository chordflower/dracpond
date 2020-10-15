package cc.chordflower.dracpond.utils;

/*-
 * #%L
 * dracpond
 * %%
 * Copyright (C) 2020 carddamom
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Implements the file api using the given path instead, to allow for diferent filesystem implementations.
 */
public class ProxyFile extends File {

  private static final long serialVersionUID = 1L;
  private final Path _filePath;

  public ProxyFile( Path filePath ) {
    super( "/" );
    this._filePath = filePath.normalize( );
  }

  @Override
  public boolean canExecute( ) {
    return Files.isExecutable( this._filePath );
  }

  @Override
  public boolean canRead( ) {
    return Files.isReadable( this._filePath );
  }

  @Override
  public boolean canWrite( ) {
    return Files.isWritable( this._filePath );
  }

  @Override
  public int compareTo( File pathname ) {
    return this._filePath.compareTo( pathname.toPath( ) );
  }

  @Override
  public boolean createNewFile( ) throws IOException {
    try {
      return Files.createFile( this._filePath ) != null;
    } catch( FileAlreadyExistsException ex ) {
      return false;
    }
  }

  @Override
  public boolean delete( ) {
    try {
      Files.delete( this._filePath );
      return true;
    } catch( IOException ex ) {
      return false;
    }
  }

  @Override
  public void deleteOnExit( ) {
    this.delete( );
  }

  @Override
  public boolean equals( Object obj ) {
    if( obj instanceof File ) {
      return this._filePath.equals( ( ( File )obj ).toPath( ) );
    }
    return false;
  }

  @Override
  public boolean exists( ) {
    return Files.exists( this._filePath );
  }

  @Override
  public File getAbsoluteFile( ) {
    return new ProxyFile( this._filePath.toAbsolutePath( ) );
  }

  @Override
  public String getAbsolutePath( ) {
    return this._filePath.toAbsolutePath( ).toString( );
  }

  @Override
  public File getCanonicalFile( ) throws IOException {
    return new ProxyFile( this._filePath.toAbsolutePath( ).normalize( ) );
  }

  @Override
  public String getCanonicalPath( ) throws IOException {
    return this._filePath.toAbsolutePath( ).normalize( ).toString( );
  }

  @Override
  public long getFreeSpace( ) {
    return 0L;
  }

  @Override
  public String getName( ) {
    return this._filePath.getFileName( ).toString( );
  }

  @Override
  public String getParent( ) {
    return this._filePath.toAbsolutePath( ).normalize( ).getParent( ).toString( );
  }

  @Override
  public File getParentFile( ) {
    return new ProxyFile( this._filePath.toAbsolutePath( ).normalize( ).getParent( ) );
  }

  @Override
  public String getPath( ) {
    return this._filePath.toString( );
  }

  @Override
  public long getTotalSpace( ) {
    return 0L;
  }

  @Override
  public long getUsableSpace( ) {
    return 0L;
  }

  @Override
  public int hashCode( ) {
    return this._filePath.hashCode( );
  }

  @Override
  public boolean isAbsolute( ) {
    return this._filePath.isAbsolute( );
  }

  @Override
  public boolean isDirectory( ) {
    return Files.isDirectory( this._filePath );
  }

  @Override
  public boolean isFile( ) {
    return Files.isRegularFile( this._filePath );
  }

  @Override
  public boolean isHidden( ) {
    try {
      return Files.isHidden( this._filePath );
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public long lastModified( ) {
    try {
      return Files.getLastModifiedTime( this._filePath ).toMillis( );
    } catch( IOException e ) {
      return 0L;
    }
  }

  @Override
  public long length( ) {
    try {
      return Files.size( this._filePath );
    } catch( IOException e ) {
      return 0L;
    }
  }

  @Override
  public String[ ] list( ) {
    try {
      return Files.list( this._filePath ).map( Object::toString ).toArray( String[ ]::new );
    } catch( IOException e ) {
      return null;
    }
  }

  @Override
  public String[ ] list( FilenameFilter filter ) {
    try {
      return Files.list( this._filePath ).filter( path -> filter.accept( this, path.getFileName( ).toString( ) ) ).map( Object::toString ).toArray( String[ ]::new );
    } catch( IOException e ) {
      return null;
    }
  }

  @Override
  public File[ ] listFiles( ) {
    try {
      return Files.list( this._filePath ).map( ProxyFile::new ).toArray( File[ ]::new );
    } catch( IOException e ) {
      return null;
    }
  }

  @Override
  public File[ ] listFiles( FileFilter filter ) {
    try {
      return Files.list( this._filePath ).map( ProxyFile::new ).filter( filter::accept ).toArray( File[ ]::new );
    } catch( IOException e ) {
      return null;
    }
  }

  @Override
  public File[ ] listFiles( FilenameFilter filter ) {
    try {
      return Files.list( this._filePath ).filter( path -> filter.accept( this, path.getFileName( ).toString( ) ) ).map( ProxyFile::new ).toArray( File[ ]::new );
    } catch( IOException e ) {
      return null;
    }
  }

  @Override
  public boolean mkdir( ) {
    try {
      return Files.createDirectory( this._filePath ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public boolean mkdirs( ) {
    try {
      return Files.createDirectories( this._filePath ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public boolean renameTo( File dest ) {
    try {
      return Files.move( this._filePath, dest.toPath( ) ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public boolean setExecutable( boolean executable ) {
    return this.setExecutable( executable, true );
  }

  @Override
  public boolean setExecutable( boolean executable, boolean ownerOnly ) {
    try {
      Set< PosixFilePermission > permissions = new HashSet<>( ( Set< PosixFilePermission > )Files.getAttribute( this._filePath, "posix.permissions" ) );
      if( executable ) {
        var newPermissions = ownerOnly ? EnumSet.of( PosixFilePermission.OWNER_EXECUTE ) : EnumSet.of( PosixFilePermission.GROUP_EXECUTE, PosixFilePermission.OTHERS_EXECUTE, PosixFilePermission.OWNER_EXECUTE );
        permissions.addAll( newPermissions );
      } else {
        permissions.remove( PosixFilePermission.OWNER_EXECUTE );
        if( !ownerOnly ) {
          permissions.remove( PosixFilePermission.GROUP_EXECUTE );
          permissions.remove( PosixFilePermission.OTHERS_EXECUTE );
        }
      }
      return Files.setAttribute( this._filePath, "posix.permissions", permissions ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public boolean setLastModified( long time ) {
    try {
      return Files.setLastModifiedTime( this._filePath, FileTime.fromMillis( time ) ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public boolean setReadable( boolean readable ) {
    return this.setReadable( readable, true );
  }

  @Override
  public boolean setReadable( boolean readable, boolean ownerOnly ) {
    try {
      Set< PosixFilePermission > permissions = new HashSet<>( ( Set< PosixFilePermission > )Files.getAttribute( this._filePath, "posix.permissions" ) );
      if( readable ) {
        var newPermissions = ownerOnly ? EnumSet.of( PosixFilePermission.OWNER_READ ) : EnumSet.of( PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_READ );
        permissions.addAll( newPermissions );
      } else {
        permissions.remove( PosixFilePermission.OWNER_READ );
        if( !ownerOnly ) {
          permissions.remove( PosixFilePermission.GROUP_READ );
          permissions.remove( PosixFilePermission.OTHERS_READ );
        }
      }
      return Files.setAttribute( this._filePath, "posix.permissions", permissions ) != null;
    } catch( IOException e ) {
      try {
        return Files.setAttribute( this._filePath, "dos.readonly", Boolean.valueOf( readable ) ) != null;
      } catch( IOException e1 ) {
        return false;
      }
    }
  }

  @Override
  public boolean setReadOnly( ) {
    try {
      Set< PosixFilePermission > newPermissions = EnumSet.of( PosixFilePermission.GROUP_READ, PosixFilePermission.OTHERS_READ, PosixFilePermission.OWNER_READ );
      Set< PosixFilePermission > permissions = new HashSet<>( ( Set< PosixFilePermission > )Files.getAttribute( this._filePath, "posix.permissions" ) );
      permissions.addAll( newPermissions );
      return Files.setAttribute( this._filePath, "posix.permissions", permissions ) != null;
    } catch( IOException e ) {
      try {
        return Files.setAttribute( this._filePath, "dos.readonly", Boolean.TRUE ) != null;
      } catch( IOException e1 ) {
        return false;
      }
    }
  }

  @Override
  public boolean setWritable( boolean writable ) {
    return this.setWritable( writable, true );
  }

  @Override
  public boolean setWritable( boolean writable, boolean ownerOnly ) {
    try {
      Set< PosixFilePermission > permissions = new HashSet<>( ( Set< PosixFilePermission > )Files.getAttribute( this._filePath, "posix.permissions" ) );
      if( writable ) {
        var newPermissions = ownerOnly ? EnumSet.of( PosixFilePermission.OWNER_WRITE ) : EnumSet.of( PosixFilePermission.GROUP_WRITE, PosixFilePermission.OTHERS_WRITE, PosixFilePermission.OWNER_WRITE );
        permissions.addAll( newPermissions );
      } else {
        permissions.remove( PosixFilePermission.OWNER_WRITE );
        if( !ownerOnly ) {
          permissions.remove( PosixFilePermission.GROUP_WRITE );
          permissions.remove( PosixFilePermission.OTHERS_WRITE );
        }
      }
      return Files.setAttribute( this._filePath, "posix.permissions", permissions ) != null;
    } catch( IOException e ) {
      return false;
    }
  }

  @Override
  public Path toPath( ) {
    return this._filePath;
  }

  @Override
  public String toString( ) {
    return this._filePath.toString( );
  }

  @Override
  public URI toURI( ) {
    return this._filePath.toUri( );
  }

}
